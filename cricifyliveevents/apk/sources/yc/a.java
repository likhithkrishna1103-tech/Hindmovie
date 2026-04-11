package yc;

import android.content.Context;
import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Bundle f15021a;

    public a(Context context) {
        ge.i.e(context, "appContext");
        Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
        this.f15021a = bundle == null ? Bundle.EMPTY : bundle;
    }

    @Override // yc.o
    public final Boolean a() {
        Bundle bundle = this.f15021a;
        if (bundle.containsKey("firebase_sessions_enabled")) {
            return Boolean.valueOf(bundle.getBoolean("firebase_sessions_enabled"));
        }
        return null;
    }

    @Override // yc.o
    public final Double b() {
        Bundle bundle = this.f15021a;
        if (bundle.containsKey("firebase_sessions_sampling_rate")) {
            return Double.valueOf(bundle.getDouble("firebase_sessions_sampling_rate"));
        }
        return null;
    }

    @Override // yc.o
    public final oe.a c() {
        Bundle bundle = this.f15021a;
        if (bundle.containsKey("firebase_sessions_sessions_restart_timeout")) {
            return new oe.a(com.bumptech.glide.d.D(bundle.getInt("firebase_sessions_sessions_restart_timeout"), oe.c.SECONDS));
        }
        return null;
    }

    @Override // yc.o
    public final Object d(vd.c cVar) {
        return rd.l.f11003a;
    }
}
