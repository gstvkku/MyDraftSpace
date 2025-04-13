package io.codeforall.bootcamp;

public class Pojo {

    private String status;
    private String error;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "Pojo{" +
                "status='" + status + '\'' +
                ", error='" + error + '\'' +
                '}';
    }

}
