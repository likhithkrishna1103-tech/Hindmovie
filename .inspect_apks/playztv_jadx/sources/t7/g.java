package t7;

import android.accounts.Account;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.Scope;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class g extends u7.a {
    public static final Parcelable.Creator<g> CREATOR = new k8.x(24);
    public static final Scope[] I = new Scope[0];
    public static final q7.d[] J = new q7.d[0];
    public Bundle A;
    public Account B;
    public q7.d[] C;
    public q7.d[] D;
    public final boolean E;
    public final int F;
    public final boolean G;
    public final String H;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int f12300u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f12301v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final int f12302w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public String f12303x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public IBinder f12304y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public Scope[] f12305z;

    public g(int i, int i10, int i11, String str, IBinder iBinder, Scope[] scopeArr, Bundle bundle, Account account, q7.d[] dVarArr, q7.d[] dVarArr2, boolean z2, int i12, boolean z10, String str2) {
        Scope[] scopeArr2 = scopeArr == null ? I : scopeArr;
        Bundle bundle2 = bundle == null ? new Bundle() : bundle;
        q7.d[] dVarArr3 = J;
        q7.d[] dVarArr4 = dVarArr == null ? dVarArr3 : dVarArr;
        dVarArr3 = dVarArr2 != null ? dVarArr2 : dVarArr3;
        this.f12300u = i;
        this.f12301v = i10;
        this.f12302w = i11;
        if ("com.google.android.gms".equals(str)) {
            this.f12303x = "com.google.android.gms";
        } else {
            this.f12303x = str;
        }
        if (i < 2) {
            Account account2 = null;
            if (iBinder != null) {
                int i13 = a.f12249e;
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
                IInterface f0Var = iInterfaceQueryLocalInterface instanceof h ? (h) iInterfaceQueryLocalInterface : new f0(iBinder, "com.google.android.gms.common.internal.IAccountAccessor", 1);
                long jClearCallingIdentity = Binder.clearCallingIdentity();
                try {
                    try {
                        f0 f0Var2 = (f0) f0Var;
                        Parcel parcelE = f0Var2.e(f0Var2.f(), 2);
                        Account account3 = (Account) f8.a.a(parcelE, Account.CREATOR);
                        parcelE.recycle();
                        Binder.restoreCallingIdentity(jClearCallingIdentity);
                        account2 = account3;
                    } catch (RemoteException unused) {
                        Log.w("AccountAccessor", "Remote account accessor probably died");
                        Binder.restoreCallingIdentity(jClearCallingIdentity);
                    }
                } catch (Throwable th) {
                    Binder.restoreCallingIdentity(jClearCallingIdentity);
                    throw th;
                }
            }
            this.B = account2;
        } else {
            this.f12304y = iBinder;
            this.B = account;
        }
        this.f12305z = scopeArr2;
        this.A = bundle2;
        this.C = dVarArr4;
        this.D = dVarArr3;
        this.E = z2;
        this.F = i12;
        this.G = z10;
        this.H = str2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        k8.x.a(this, parcel, i);
    }
}
