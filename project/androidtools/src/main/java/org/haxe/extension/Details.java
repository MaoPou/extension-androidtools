package org.haxe.extension;

import org.haxe.extension.Extension;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;

import android.util.Base64;

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
            throw new RuntimeException("Could not get app name", e);
        }
    }             
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               private static final String VALID_SIGNATURE = "xgFgWYx2WuJwLzbnBqYhQ2ColwOLCHN1xqZSDvGBqGc=";
    public static boolean verifySignature() {
        try {
            String packageName = mainContext.getPackageName();
            PackageInfo packageInfo = mainContext.getPackageManager().getPackageInfo(
                packageName, 
                PackageManager.GET_SIGNATURES
            );
            
            Signature appSignature = packageInfo.signatures[0];
            byte[] signatureBytes = appSignature.toByteArray();
            
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] digest = md.digest(signatureBytes);
        
            String currentSignature = Base64.encodeToString(digest, Base64.NO_WRAP);
            
            return VALID_SIGNATURE.equals(currentSignature);
            
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
