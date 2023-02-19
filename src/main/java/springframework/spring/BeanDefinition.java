package springframework.spring;

public class BeanDefinition {
    private String scope;

    private Class<?> clazz;

    public String getScope() {
        return scope;
    }

    public Class<?> getClazz() {
        return clazz;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public void setClazz(Class<?> clazz) {
        this.clazz = clazz;
    }
}
