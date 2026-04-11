package v7;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.Scope;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import s7.j;
import t7.e;
import t7.e0;
import t7.m;
import t7.v;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class d extends e implements r7.a {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Set f13331y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final m f13332z;

    /* JADX WARN: Illegal instructions before constructor call */
    public d(Context context, Looper looper, kc.b bVar, m mVar, j jVar, j jVar2) {
        e0 e0VarA = e0.a(context);
        q7.e eVar = q7.e.f11038d;
        v.h(jVar);
        v.h(jVar2);
        super(context, looper, e0VarA, eVar, 270, new o4.c(jVar), new q0.e(9, jVar2), (String) bVar.f7621w);
        Set set = (Set) bVar.f7620v;
        Iterator it = set.iterator();
        while (it.hasNext()) {
            if (!set.contains((Scope) it.next())) {
                throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
            }
        }
        this.f13331y = set;
        this.f13332z = mVar;
    }

    @Override // r7.a
    public final Set c() {
        return m() ? this.f13331y : Collections.EMPTY_SET;
    }

    @Override // t7.e
    public final int f() {
        return 203400000;
    }

    @Override // t7.e
    public final IInterface p(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.service.IClientTelemetryService");
        return iInterfaceQueryLocalInterface instanceof a ? (a) iInterfaceQueryLocalInterface : new a(iBinder, "com.google.android.gms.common.internal.service.IClientTelemetryService");
    }

    @Override // t7.e
    public final Account q() {
        return null;
    }

    @Override // t7.e
    public final q7.d[] r() {
        return d8.c.f4101b;
    }

    @Override // t7.e
    public final Bundle s() {
        m mVar = this.f13332z;
        mVar.getClass();
        Bundle bundle = new Bundle();
        String str = mVar.f12322a;
        if (str != null) {
            bundle.putString("api", str);
        }
        return bundle;
    }

    @Override // t7.e
    public final Set t() {
        return this.f13331y;
    }

    @Override // t7.e
    public final String v() {
        return "com.google.android.gms.common.internal.service.IClientTelemetryService";
    }

    @Override // t7.e
    public final String w() {
        return "com.google.android.gms.common.telemetry.service.START";
    }

    @Override // t7.e
    public final boolean x() {
        return true;
    }
}
