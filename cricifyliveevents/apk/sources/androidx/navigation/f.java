package androidx.navigation;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import androidx.lifecycle.m0;
import androidx.lifecycle.r0;
import androidx.lifecycle.t0;
import androidx.lifecycle.u0;
import java.util.HashMap;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class f implements androidx.lifecycle.s, u0, androidx.lifecycle.i, b5.f {
    public final UUID A;
    public androidx.lifecycle.n B;
    public androidx.lifecycle.n C;
    public final h D;
    public m0 E;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Context f1330v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final l f1331w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Bundle f1332x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final androidx.lifecycle.u f1333y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final com.bumptech.glide.manager.u f1334z;

    public f(Context context, l lVar, Bundle bundle, androidx.navigation.fragment.e eVar, h hVar) {
        this(context, lVar, bundle, eVar, hVar, UUID.randomUUID(), null);
    }

    @Override // b5.f
    public final b5.e a() {
        return (b5.e) this.f1334z.f2291x;
    }

    public final void b() {
        int iOrdinal = this.B.ordinal();
        int iOrdinal2 = this.C.ordinal();
        androidx.lifecycle.u uVar = this.f1333y;
        if (iOrdinal < iOrdinal2) {
            uVar.g(this.B);
        } else {
            uVar.g(this.C);
        }
    }

    @Override // androidx.lifecycle.i
    public final r0 c() {
        if (this.E == null) {
            this.E = new m0((Application) this.f1330v.getApplicationContext(), this, this.f1332x);
        }
        return this.E;
    }

    @Override // androidx.lifecycle.i
    public final a7.a d() {
        return t1.a.f11832x;
    }

    @Override // androidx.lifecycle.u0
    public final t0 e() {
        h hVar = this.D;
        if (hVar == null) {
            throw new IllegalStateException("You must call setViewModelStore() on your NavHostController before accessing the ViewModelStore of a navigation graph.");
        }
        HashMap map = hVar.f1354d;
        UUID uuid = this.A;
        t0 t0Var = (t0) map.get(uuid);
        if (t0Var != null) {
            return t0Var;
        }
        t0 t0Var2 = new t0();
        map.put(uuid, t0Var2);
        return t0Var2;
    }

    @Override // androidx.lifecycle.s
    public final androidx.lifecycle.u f() {
        return this.f1333y;
    }

    public f(Context context, l lVar, Bundle bundle, androidx.lifecycle.s sVar, h hVar, UUID uuid, Bundle bundle2) {
        this.f1333y = new androidx.lifecycle.u(this);
        com.bumptech.glide.manager.u uVar = new com.bumptech.glide.manager.u(this);
        this.f1334z = uVar;
        this.B = androidx.lifecycle.n.f1181x;
        this.C = androidx.lifecycle.n.f1183z;
        this.f1330v = context;
        this.A = uuid;
        this.f1331w = lVar;
        this.f1332x = bundle;
        this.D = hVar;
        uVar.e(bundle2);
        if (sVar != null) {
            this.B = sVar.f().f1200c;
        }
    }
}
