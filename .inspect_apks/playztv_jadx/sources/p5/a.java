package p5;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import java.util.Map;
import l5.x;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Object f10203d = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f10204a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f10205b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map f10206c;

    public a(Drawable.Callback callback, String str, Map map) {
        if (TextUtils.isEmpty(str) || str.charAt(str.length() - 1) == '/') {
            this.f10205b = str;
        } else {
            this.f10205b = str.concat("/");
        }
        this.f10206c = map;
        if (callback instanceof View) {
            this.f10204a = ((View) callback).getContext().getApplicationContext();
        } else {
            this.f10204a = null;
        }
    }

    public final void a(String str, Bitmap bitmap) {
        synchronized (f10203d) {
            ((x) this.f10206c.get(str)).f = bitmap;
        }
    }
}
