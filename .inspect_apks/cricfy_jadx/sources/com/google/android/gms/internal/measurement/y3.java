package com.google.android.gms.internal.measurement;

import android.net.Uri;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class y3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Uri f2731a = Uri.parse("content://com.google.android.gsf.gservices");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Pattern f2732b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Pattern f2733c;

    static {
        Uri.parse("content://com.google.android.gsf.gservices/prefix");
        f2732b = Pattern.compile("^(1|true|t|on|yes|y)$", 2);
        f2733c = Pattern.compile("^(0|false|f|off|no|n)$", 2);
    }
}
