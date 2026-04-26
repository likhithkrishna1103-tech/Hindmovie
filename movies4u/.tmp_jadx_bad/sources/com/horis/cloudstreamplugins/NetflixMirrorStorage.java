package com.horis.cloudstreamplugins;

import android.content.Context;
import android.content.SharedPreferences;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: NetflixMirrorStorage.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0005J\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fJ\u0014\u0010\r\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020\u000f0\u000eJ\u0006\u0010\u0010\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/horis/cloudstreamplugins/NetflixMirrorStorage;", "", "<init>", "()V", "context", "Landroid/content/Context;", "prefs", "Landroid/content/SharedPreferences;", "init", "", "saveCookie", "cookie", "", "getCookie", "Lkotlin/Pair;", "", "clearCookie", "NetflixMirrorProvider"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class NetflixMirrorStorage {

    @NotNull
    public static final NetflixMirrorStorage INSTANCE = new NetflixMirrorStorage();
    private static Context context;
    private static SharedPreferences prefs;

    private NetflixMirrorStorage() {
    }

    public final void init(@NotNull Context context2) {
        context = context2.getApplicationContext();
        prefs = context2.getSharedPreferences("NetflixMirrorPrefs", 0);
    }

    public final void saveCookie(@NotNull String cookie) {
        SharedPreferences sharedPreferences = prefs;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("prefs");
            sharedPreferences = null;
        }
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("nf_cookie", cookie);
        editor.putLong("nf_cookie_timestamp", System.currentTimeMillis());
        editor.apply();
    }

    @NotNull
    public final Pair<String, Long> getCookie() {
        SharedPreferences sharedPreferences = prefs;
        SharedPreferences sharedPreferences2 = null;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("prefs");
            sharedPreferences = null;
        }
        String string = sharedPreferences.getString("nf_cookie", null);
        SharedPreferences sharedPreferences3 = prefs;
        if (sharedPreferences3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("prefs");
        } else {
            sharedPreferences2 = sharedPreferences3;
        }
        return new Pair<>(string, Long.valueOf(sharedPreferences2.getLong("nf_cookie_timestamp", 0L)));
    }

    public final void clearCookie() {
        SharedPreferences sharedPreferences = prefs;
        if (sharedPreferences == null) {
            Intrinsics.throwUninitializedPropertyAccessException("prefs");
            sharedPreferences = null;
        }
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove("nf_cookie");
        editor.remove("nf_cookie_timestamp");
        editor.apply();
    }
}
