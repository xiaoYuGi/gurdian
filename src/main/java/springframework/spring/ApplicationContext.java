package springframework.spring;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class ApplicationContext {
    private final Class<?> configClass;

    private static final String SINGLETON = "singleton";

    private static final ConcurrentMap<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

    private static final ConcurrentMap<String, Object> singletonBeans = new ConcurrentHashMap<>();

    public ApplicationContext(Class<?> configClass) throws IOException {
        this.configClass = configClass;
        scanClass();
        for (Map.Entry<String, BeanDefinition> entry : beanDefinitionMap.entrySet()) {
            BeanDefinition beanDefinition = entry.getValue();
            if (SINGLETON.equals(beanDefinition.getScope())) {
                singletonBeans.put(entry.getKey(), createBean(beanDefinition));
            }
        }
    }

    private void scanClass() throws IOException {
        ComponentScan annotation = this.configClass.getDeclaredAnnotation(ComponentScan.class);
        String path = annotation.value();
        System.out.println("scanning the classes path : [" + path + "]");

        ClassLoader classLoader = ApplicationContext.class.getClassLoader();
        URL resource = classLoader.getResource(path.replace('.', '/'));
        List<File> list = loadFiles(new File(resource.getFile()));
        for (File file : list) {
            if (!file.getName().endsWith(".class")) {
                continue;
            }
            String fullClassName = file.getAbsolutePath()
                    .substring(file.getCanonicalPath().indexOf("com"))
                    .replace('\\', '.');
            fullClassName = fullClassName.substring(0, fullClassName.indexOf(".class"));
            Class<?> clazz;
            try {
                clazz = classLoader.loadClass(fullClassName);
                if (clazz.isAnnotationPresent(Component.class)) {
                    Component component = clazz.getDeclaredAnnotation(Component.class);
                    String beanName = component.value();
                    BeanDefinition beanDefinition = new BeanDefinition();
                    beanDefinition.setClazz(clazz);
                    if (clazz.isAnnotationPresent(Scope.class)) {
                        Scope scope = clazz.getDeclaredAnnotation(Scope.class);
                        beanDefinition.setScope(scope.value());
                    } else {
                        beanDefinition.setScope(SINGLETON);
                    }
                    beanDefinitionMap.put(beanName, beanDefinition);
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    private Object createBean(BeanDefinition beanDefinition) {
        try {
            return beanDefinition.getClazz().getDeclaredConstructor().newInstance();
        } catch (InstantiationException | NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    private List<File> loadFiles(File file) {
        List<File> ans = new ArrayList<>();
        if (file == null) {
            return ans;
        }
        if (file.isFile()) {
            ans.add(file);
            return ans;
        }

        Queue<File> q = new ArrayDeque<>();
        q.offer(file);
        while (!q.isEmpty()) {
            File cur = q.poll();
            if (cur.isDirectory()) {
                File[] files = cur.listFiles();
                if (files != null) {
                    for (File f : files) {
                        q.offer(f);
                    }
                }
            } else {
                ans.add(cur);
            }
        }
        return ans;
    }

    public <T> T getBean(String beanName) {
        if (!beanDefinitionMap.containsKey(beanName)) {
            throw new NullPointerException();
        }
        BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
        if (SINGLETON.equals(beanDefinition.getScope())) {
            return (T) singletonBeans.get(beanName);
        } else {
            return (T) createBean(beanDefinition);
        }
    }
}
