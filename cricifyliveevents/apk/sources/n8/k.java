package n8;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.dash.DashMediaSource$Factory;
import androidx.media3.exoplayer.hls.HlsMediaSource$Factory;
import java.lang.reflect.GenericDeclaration;
import java.util.HashMap;
import l4.c0;
import o8.u;
import s2.b0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class k implements o8.d {
    public Object A;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f8884v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Object f8885w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Object f8886x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Object f8887y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Object f8888z;

    public k(d dVar, m8.a aVar, a aVar2) {
        this.A = dVar;
        this.f8887y = null;
        this.f8888z = null;
        this.f8884v = false;
        this.f8885w = aVar;
        this.f8886x = aVar2;
    }

    public synchronized boolean a() {
        boolean zH;
        Boolean bool = (Boolean) this.f8888z;
        if (bool != null) {
            zH = bool.booleanValue();
        } else {
            try {
                zH = ((ab.g) this.f8885w).h();
            } catch (IllegalStateException unused) {
                zH = false;
            }
        }
        c(zH);
        return zH;
    }

    public ta.l b(int i) {
        ta.l oVar;
        ta.l lVar;
        HashMap map = (HashMap) this.f8886x;
        ta.l lVar2 = (ta.l) map.get(Integer.valueOf(i));
        if (lVar2 != null) {
            return lVar2;
        }
        final c0 c0Var = (c0) this.f8888z;
        c0Var.getClass();
        if (i != 0) {
            final int i10 = 1;
            if (i != 1) {
                final int i11 = 2;
                if (i != 2) {
                    final int i12 = 3;
                    if (i == 3) {
                        oVar = new g2.o(5, Class.forName("androidx.media3.exoplayer.rtsp.RtspMediaSource$Factory").asSubclass(b0.class));
                    } else {
                        if (i != 4) {
                            throw new IllegalArgumentException(l0.e.g(i, "Unrecognized contentType: "));
                        }
                        oVar = new ta.l() { // from class: s2.o
                            @Override // ta.l
                            public final Object get() {
                                switch (i12) {
                                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                                        return p.e((Class) this, c0Var);
                                    case 1:
                                        return p.e((Class) this, c0Var);
                                    case 2:
                                        return p.e((Class) this, c0Var);
                                    default:
                                        return new u0(c0Var, (a3.n) ((n8.k) this).f8885w);
                                }
                            }
                        };
                    }
                } else {
                    final Class clsAsSubclass = HlsMediaSource$Factory.class.asSubclass(b0.class);
                    lVar = new ta.l() { // from class: s2.o
                        @Override // ta.l
                        public final Object get() {
                            switch (i11) {
                                case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                                    return p.e((Class) clsAsSubclass, c0Var);
                                case 1:
                                    return p.e((Class) clsAsSubclass, c0Var);
                                case 2:
                                    return p.e((Class) clsAsSubclass, c0Var);
                                default:
                                    return new u0(c0Var, (a3.n) ((n8.k) clsAsSubclass).f8885w);
                            }
                        }
                    };
                }
            } else {
                final GenericDeclaration genericDeclarationAsSubclass = Class.forName("androidx.media3.exoplayer.smoothstreaming.SsMediaSource$Factory").asSubclass(b0.class);
                lVar = new ta.l() { // from class: s2.o
                    @Override // ta.l
                    public final Object get() {
                        switch (i10) {
                            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                                return p.e((Class) genericDeclarationAsSubclass, c0Var);
                            case 1:
                                return p.e((Class) genericDeclarationAsSubclass, c0Var);
                            case 2:
                                return p.e((Class) genericDeclarationAsSubclass, c0Var);
                            default:
                                return new u0(c0Var, (a3.n) ((n8.k) genericDeclarationAsSubclass).f8885w);
                        }
                    }
                };
            }
            oVar = lVar;
        } else {
            final Class clsAsSubclass2 = DashMediaSource$Factory.class.asSubclass(b0.class);
            final int i13 = 0;
            oVar = new ta.l() { // from class: s2.o
                @Override // ta.l
                public final Object get() {
                    switch (i13) {
                        case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                            return p.e((Class) clsAsSubclass2, c0Var);
                        case 1:
                            return p.e((Class) clsAsSubclass2, c0Var);
                        case 2:
                            return p.e((Class) clsAsSubclass2, c0Var);
                        default:
                            return new u0(c0Var, (a3.n) ((n8.k) clsAsSubclass2).f8885w);
                    }
                }
            };
        }
        map.put(Integer.valueOf(i), oVar);
        return oVar;
    }

    public void c(boolean z10) {
        String str = "Crashlytics automatic data collection " + (z10 ? "ENABLED" : "DISABLED") + " by " + (((Boolean) this.f8888z) == null ? "global Firebase setting" : this.f8884v ? "firebase_crashlytics_collection_enabled manifest flag" : "API") + ".";
        if (Log.isLoggable("FirebaseCrashlytics", 3)) {
            Log.d("FirebaseCrashlytics", str, null);
        }
    }

    public void d(l8.b bVar) {
        i iVar = (i) ((d) this.A).E.get((a) this.f8886x);
        if (iVar != null) {
            u.c(iVar.f8881n.H);
            m8.a aVar = iVar.f8874e;
            aVar.c("onSignInFailed for " + aVar.getClass().getName() + " with " + String.valueOf(bVar));
            iVar.o(bVar, null);
        }
    }

    @Override // o8.d
    public void h(l8.b bVar) {
        ((d) this.A).H.post(new k8.j(1, this, bVar, false));
    }

    public k(ab.g gVar) {
        Boolean boolValueOf;
        PackageManager packageManager;
        ApplicationInfo applicationInfo;
        Bundle bundle;
        this.f8886x = new Object();
        this.f8887y = new j9.i();
        this.f8884v = false;
        this.A = new j9.i();
        gVar.a();
        Context context = gVar.f390a;
        this.f8885w = gVar;
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.google.firebase.crashlytics", 0);
        if (sharedPreferences.contains("firebase_crashlytics_collection_enabled")) {
            this.f8884v = false;
            boolValueOf = Boolean.valueOf(sharedPreferences.getBoolean("firebase_crashlytics_collection_enabled", true));
        } else {
            boolValueOf = null;
        }
        if (boolValueOf == null) {
            try {
                packageManager = context.getPackageManager();
            } catch (PackageManager.NameNotFoundException e9) {
                Log.e("FirebaseCrashlytics", "Could not read data collection permission from manifest", e9);
            }
            Boolean boolValueOf2 = (packageManager == null || (applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 128)) == null || (bundle = applicationInfo.metaData) == null || !bundle.containsKey("firebase_crashlytics_collection_enabled")) ? null : Boolean.valueOf(applicationInfo.metaData.getBoolean("firebase_crashlytics_collection_enabled"));
            if (boolValueOf2 == null) {
                this.f8884v = false;
                boolValueOf = null;
            } else {
                this.f8884v = true;
                boolValueOf = Boolean.valueOf(Boolean.TRUE.equals(boolValueOf2));
            }
        }
        this.f8888z = boolValueOf;
        synchronized (this.f8886x) {
            try {
                if (a()) {
                    ((j9.i) this.f8887y).c(null);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public k(a3.n nVar, x3.e eVar) {
        this.f8885w = nVar;
        this.A = eVar;
        this.f8886x = new HashMap();
        this.f8887y = new HashMap();
        this.f8884v = true;
    }
}
