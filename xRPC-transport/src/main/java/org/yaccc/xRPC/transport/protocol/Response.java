package org.yaccc.xRPC.transport.protocol;


import java.io.Serializable;

/**
 * Created by zhaodong/yaccc(github.com/yaccc)|xRPC on 16/2/9
 */
public class Response implements Serializable {

    private String requestId;
    private int status;
    private Object result;
    private Throwable throwable;

    public Response() {
    }

    public String getRequestId() {
        return this.requestId;
    }

    public int getStatus() {
        return this.status;
    }

    public Object getResult() {
        return this.result;
    }

    public Throwable getThrowable() {
        return this.throwable;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Response)) return false;
        final Response other = (Response) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$requestId = this.requestId;
        final Object other$requestId = other.requestId;
        if (this$requestId == null ? other$requestId != null : !this$requestId.equals(other$requestId)) return false;
        if (this.status != other.status) return false;
        final Object this$result = this.result;
        final Object other$result = other.result;
        if (this$result == null ? other$result != null : !this$result.equals(other$result)) return false;
        final Object this$throwable = this.throwable;
        final Object other$throwable = other.throwable;
        if (this$throwable == null ? other$throwable != null : !this$throwable.equals(other$throwable)) return false;
        return true;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $requestId = this.requestId;
        result = result * PRIME + ($requestId == null ? 0 : $requestId.hashCode());
        result = result * PRIME + this.status;
        final Object $result = this.result;
        result = result * PRIME + ($result == null ? 0 : $result.hashCode());
        final Object $throwable = this.throwable;
        result = result * PRIME + ($throwable == null ? 0 : $throwable.hashCode());
        return result;
    }

    protected boolean canEqual(Object other) {
        return other instanceof Response;
    }

    public String toString() {
        return "org.yaccc.xRPC.transport.protocol.Response(requestId=" + this.requestId + ", status=" + this.status + ", result=" + this.result + ", throwable=" + this.throwable + ")";
    }
}
