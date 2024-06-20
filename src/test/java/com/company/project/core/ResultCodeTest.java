package com.company.project.core;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultCodeTest {

    @Test
    public void testCode() {
        assertThat(ResultCode.SUCCESS.code()).isEqualTo(0);
        assertThat(ResultCode.FAIL.code()).isEqualTo(0);
        assertThat(ResultCode.UNAUTHORIZED.code()).isEqualTo(0);
        assertThat(ResultCode.NOT_FOUND.code()).isEqualTo(0);
        assertThat(ResultCode.INTERNAL_SERVER_ERROR.code()).isEqualTo(0);
        assertThat(ResultCode.SENDER_USER_ERROR.code()).isEqualTo(0);
        assertThat(ResultCode.RECIPIENT_ERROR.code()).isEqualTo(0);
        assertThat(ResultCode.SENDER_ERROR.code()).isEqualTo(0);
        assertThat(ResultCode.ADMIN_DELETE_ERROR.code()).isEqualTo(0);
        assertThat(ResultCode.ADMIN_ERROR.code()).isEqualTo(0);
        assertThat(ResultCode.COLLECT_PARAM_ERROR.code()).isEqualTo(0);
        assertThat(ResultCode.MOMENT_COLLECT_ERROR.code()).isEqualTo(0);
        assertThat(ResultCode.MOMENT_NOT_EXIST.code()).isEqualTo(0);
        assertThat(ResultCode.MOMENT_COMENT_LIKE_RECORD_ERROR.code()).isEqualTo(0);
        assertThat(ResultCode.REPEAT_THE_THUMB_UP.code()).isEqualTo(0);
        assertThat(ResultCode.LIKE_PARAM_ERROR.code()).isEqualTo(0);
        assertThat(ResultCode.GOODS_REPERTORY_ERROR.code()).isEqualTo(0);
        assertThat(ResultCode.GOODS_NULL_ERROR.code()).isEqualTo(0);
        assertThat(ResultCode.USER_NULL_ERROR.code()).isEqualTo(0);
        assertThat(ResultCode.NOT_EXIST_TOKEN_EXCEPTION.code()).isEqualTo(0);
        assertThat(ResultCode.NOT_EXIST_USER_EXCEPTION.code()).isEqualTo(0);
        assertThat(ResultCode.OUT_TIME_TOKEN.code()).isEqualTo(0);
        assertThat(ResultCode.USER_ALREADY_EXIST.code()).isEqualTo(0);
        assertThat(ResultCode.USER_LOGIN_ERROR.code()).isEqualTo(0);
        assertThat(ResultCode.WX_USER_INFO_ERROR.code()).isEqualTo(0);
        assertThat(ResultCode.WX_LOGIN_PARAM_ERROR.code()).isEqualTo(0);
        assertThat(ResultCode.WX_LOGIN_ERROR.code()).isEqualTo(0);
        assertThat(ResultCode.FEED_PET_NULL_ERROR.code()).isEqualTo(0);
        assertThat(ResultCode.PREORDER_PET_NULL_ERROR.code()).isEqualTo(0);
        assertThat(ResultCode.PARAM_ERROR.code()).isEqualTo(0);
        assertThat(ResultCode.FILE_DOWNLOAD_ERROR.code()).isEqualTo(0);
        assertThat(ResultCode.FILE_BULL_ERROR.code()).isEqualTo(0);
        assertThat(ResultCode.FILEUPLOAD_ERROR.code()).isEqualTo(0);
        assertThat(ResultCode.USER_LOGIN_CHANNEL_ERROR.code()).isEqualTo(0);
        assertThat(ResultCode.NOT_LOGIN_EXCEPTION.code()).isEqualTo(0);
        assertThat(ResultCode.VERFIY_CODE_TIME_ERROR.code()).isEqualTo(0);
        assertThat(ResultCode.VERFIY_CODE_ERROR.code()).isEqualTo(0);
        assertThat(ResultCode.VERFIY_TOKEN_ERROR.code()).isEqualTo(0);
        assertThat(ResultCode.PASSWORD_ERROR.code()).isEqualTo(0);
        assertThat(ResultCode.USER_NOT_EXIST.code()).isEqualTo(0);
    }
}
