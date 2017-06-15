package com.migu.ross.mercenary.permission;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.migu.ross.mercenary.R;

/**
 * Created by Ross on 2017/6/14.
 */

public class ApplyForPermissionActivity extends Activity {
    private static final int REQUEST_CODE = 2;

    private PermissionsChecker mPermissionsChecker;


    // 所需的全部权限
    static final String[] PERMISSIONS = new String[]{
            Manifest.permission.READ_PHONE_STATE,
            Manifest.permission.SEND_SMS
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.permission_layout);

        mPermissionsChecker = new PermissionsChecker(this);

        Button btn = (Button)findViewById(R.id.apply_for_permission_btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mPermissionsChecker.lacksPermissions(PERMISSIONS)) {
                    startPermissionsActivity();
                }
            }
        });
    }

    private void startPermissionsActivity() {
        PermissionsActivity.startActivityForResult(this, REQUEST_CODE, PERMISSIONS);
    }

    @Override protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // 拒绝时, 关闭页面, 缺少主要权限, 无法运行
        if (requestCode == REQUEST_CODE && resultCode == PermissionsActivity.PERMISSIONS_DENIED) {
            finish();
        }
    }
}
