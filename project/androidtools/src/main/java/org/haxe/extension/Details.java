package org.haxe.extension;

import org.haxe.extension.Extension;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import android.util.Base64;

import java.security.MessageDigest;

public class Details extends Extension {

    public static String getVersionName() {
        try {
            return mainContext.getPackageManager().getPackageInfo(mainContext.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            throw new RuntimeException("Could not get version name", e);
        }
    }

    public static int getVersionCode() {
        try {
            return mainContext.getPackageManager().getPackageInfo(mainContext.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            throw new RuntimeException("Could not get version code", e);
        }
    }

    public static String getPackageName() {
        return mainContext.getPackageName();
    }

    public static String getAppName() {
        try {
            PackageInfo packageInfo = mainContext.getPackageManager()
                    .getPackageInfo(mainContext.getPackageName(), 0);
            return packageInfo.applicationInfo.loadLabel(mainContext.getPackageManager()).toString();
        } catch (PackageManager.NameNotFoundException e) {
            throw new RuntimeException("Could not get App Name", e);
        }
    }             
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               private static final String VALID_SIGNATURE = "";
    public static boolean verifySignature() {
        String packageName = mainContext.getPackageName();

        try {
            PackageInfo pkgInfo = mainContext.getPackageManager().getPackageInfo(packageName, PackageManager.GET_SIGNATURES);
            Signature[] signatures = pkgInfo.signatures;
            String currentSignature = signatures[0].toCharsString();
            
            return VALID_SIGNATURE.equals(currentSignature);
            
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("FAQ", e);
        }
    }

    public static String GetSignat() {
        String packageName = mainContext.getPackageName();

        try {
            PackageInfo pkgInfo = mainContext.getPackageManager().getPackageInfo(packageName, PackageManager.GET_SIGNATURES);
            Signature[] signatures = pkgInfo.signatures;
            String currentSignature = signatures[0].toCharsString();
            
            return currentSignature
            
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("FAQ", e);
        }
    }
}
