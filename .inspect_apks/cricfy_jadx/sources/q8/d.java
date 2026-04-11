package q8;

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
import n8.i;
import o8.e;
import o8.f0;
import o8.m;
import o8.u;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class d extends e implements m8.a {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Set f10455y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final m f10456z;

    /* JADX WARN: Illegal instructions before constructor call */
    public d(Context context, Looper looper, l7.a aVar, m mVar, i iVar, i iVar2) {
        f0 f0VarA = f0.a(context);
        l8.e eVar = l8.e.f7888d;
        u.g(iVar);
        u.g(iVar2);
        super(context, looper, f0VarA, eVar, 270, new m2.e(iVar), new kf.i(11, iVar2), (String) aVar.f7867x);
        Set set = (Set) aVar.f7866w;
        Iterator it = set.iterator();
        while (it.hasNext()) {
            if (!set.contains((Scope) it.next())) {
                throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
            }
        }
        this.f10455y = set;
        this.f10456z = mVar;
    }

    @Override // m8.a
    public final Set b() {
        return j() ? this.f10455y : Collections.EMPTY_SET;
    }

    @Override // o8.e
    public final int d() {
        return 203400000;
    }

    @Override // o8.e
    public final IInterface p(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.service.IClientTelemetryService");
        return iInterfaceQueryLocalInterface instanceof a ? (a) iInterfaceQueryLocalInterface : new a(iBinder, "com.google.android.gms.common.internal.service.IClientTelemetryService");
    }

    @Override // o8.e
    public final Account q() {
        return null;
    }

    @Override // o8.e
    public final l8.d[] r() {
        return y8.b.f14975b;
    }

    @Override // o8.e
    public final Bundle s() {
        m mVar = this.f10456z;
        mVar.getClass();
        Bundle bundle = new Bundle();
        String str = mVar.f9682a;
        if (str != null) {
            bundle.putString("api", str);
        }
        return bundle;
    }

    @Override // o8.e
    public final Set t() {
        return this.f10455y;
    }

    @Override // o8.e
    public final String v() {
        return "com.google.android.gms.common.internal.service.IClientTelemetryService";
    }

    @Override // o8.e
    public final String w() {
        return "com.google.android.gms.common.telemetry.service.START";
    }

    @Override // o8.e
    public final boolean x() {
        return true;
    }
}
