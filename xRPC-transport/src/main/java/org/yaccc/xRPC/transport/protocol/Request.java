package org.yaccc.xRPC.transport.protocol;

import java.io.Serializable;

/**
 * Created by zhaodong/yaccc(github.com/yaccc)|xRPC on 16/2/9
 */
public class Request implements Serializable {
    private String requestId;
    private String className;
    private String methodName;
    private Class<?>[] parameterTypes;
    private Object[] parameters;

    public Request() {
    }


    public String getRequestId() {
        return this.requestId;
    }

    public String getClassName() {
        return this.className;
    }

    public String getMethodName() {
        return this.methodName;
    }

    public Class<?>[] getParameterTypes() {
        return this.parameterTypes;
    }

    public Object[] getParameters() {
        return this.parameters;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public void setParameterTypes(Class<?>[] parameterTypes) {
        this.parameterTypes = parameterTypes;
    }

    public void setParameters(Object[] parameters) {
        this.parameters = parameters;
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Request)) return false;
        final Request other = (Request) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$requestId = this.requestId;
        final Object other$requestId = other.requestId;
        if (this$requestId == null ? other$requestId != null : !this$requestId.equals(other$requestId)) return false;
        final Object this$className = this.className;
        final Object other$className = other.className;
        if (this$className == null ? other$className != null : !this$className.equals(other$className)) return false;
        final Object this$methodName = this.methodName;
        final Object other$methodName = other.methodName;
        if (this$methodName == null ? other$methodName != null : !this$methodName.equals(other$methodName))
            return false;
        final Object this$parameterTypes = this.parameterTypes;
        final Object other$parameterTypes = other.parameterTypes;
        if (this$parameterTypes == null ? other$parameterTypes != null : !this$parameterTypes.equals(other$parameterTypes))
            return false;
        if (!java.util.Arrays.deepEquals(this.parameters, other.parameters)) return false;
        return true;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $requestId = this.requestId;
        result = result * PRIME + ($requestId == null ? 0 : $requestId.hashCode());
        final Object $className = this.className;
        result = result * PRIME + ($className == null ? 0 : $className.hashCode());
        final Object $methodName = this.methodName;
        result = result * PRIME + ($methodName == null ? 0 : $methodName.hashCode());
        final Object $parameterTypes = this.parameterTypes;
        result = result * PRIME + ($parameterTypes == null ? 0 : $parameterTypes.hashCode());
        result = result * PRIME + java.util.Arrays.deepHashCode(this.parameters);
        return result;
    }

    protected boolean canEqual(Object other) {
        return other instanceof Request;
    }

    public String toString() {
        return "org.yaccc.xRPC.transport.protocol.Request(requestId=" + this.requestId + ", className=" + this.className + ", methodName=" + this.methodName + ", parameterTypes=" + java.util.Arrays.deepToString(this.parameterTypes) + ", parameters=" + java.util.Arrays.deepToString(this.parameters) + ")";
    }
}
