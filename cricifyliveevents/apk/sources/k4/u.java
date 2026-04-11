package k4;

import android.os.Bundle;
import app.cricfy.tv.activities.PlayerActivity;
import java.util.HashMap;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class u {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Object f7168b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final HashMap f7169c = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b0 f7170a;

    public u(PlayerActivity playerActivity, String str, g2.g0 g0Var, ua.i0 i0Var, ua.i0 i0Var2, ua.i0 i0Var3, f9.b0 b0Var, Bundle bundle, Bundle bundle2, i2.k kVar) {
        synchronized (f7168b) {
            HashMap map = f7169c;
            if (map.containsKey(str)) {
                throw new IllegalStateException("Session ID must be unique. ID=".concat(str));
            }
            map.put(str, this);
        }
        this.f7170a = new b0(this, playerActivity, str, g0Var, i0Var, i0Var2, i0Var3, b0Var, bundle, bundle2, kVar);
    }

    public final void a() {
        try {
            synchronized (f7168b) {
                f7169c.remove(this.f7170a.i);
            }
            this.f7170a.r();
        } catch (Exception unused) {
        }
    }
}
