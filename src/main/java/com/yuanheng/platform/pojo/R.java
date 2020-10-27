package com.yuanheng.platform.pojo;

import lombok.Data;
import lombok.ToString;

/**
 * @BelongsProject: openAdminPlatform
 * @BelongsPackage: com.yuanheng.platform.pojo
 * @Author: yuanhengwcn@gmail.com
 * @CreateTime: 2020-10-26 20:13
 */

@Data
@ToString
public class R {

    private Boolean status;

    private String message;

    private Object result;

    public static R ok() {
        return new R(true);
    }

    public static R error() {
        return new R(false);
    }

    public static R ok(String message) {
        return new R(true, message);
    }

    public static R error(String message) {
        return new R(false, message);
    }

    public R() {
    }

    public R(Boolean status) {
        this.status = status;
    }

    public R(Boolean status, String message) {
        this.status = status;
        this.message = message;
    }

    public R(Boolean status, String message, Object result) {
        this.status = status;
        this.message = message;
        this.result = result;
    }
}
