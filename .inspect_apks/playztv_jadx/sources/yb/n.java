package yb;

import android.content.Context;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class n {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final HashMap f14637c = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f14638a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f14639b;

    public n(Context context, String str) {
        this.f14638a = context;
        this.f14639b = str;
    }

    public final synchronized void a() {
        this.f14638a.deleteFile(this.f14639b);
    }
}
