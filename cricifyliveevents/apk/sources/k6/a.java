package k6;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import g6.y;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Object f7202d = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f7203a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f7204b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map f7205c;

    public a(Drawable.Callback callback, String str, Map map) {
        if (TextUtils.isEmpty(str) || str.charAt(str.length() - 1) == '/') {
            this.f7204b = str;
        } else {
            this.f7204b = str.concat("/");
        }
        this.f7205c = map;
        if (callback instanceof View) {
            this.f7203a = ((View) callback).getContext().getApplicationContext();
        } else {
            this.f7203a = null;
        }
    }

    public final void a(String str, Bitmap bitmap) {
        synchronized (f7202d) {
            ((y) this.f7205c.get(str)).f = bitmap;
        }
    }
}
