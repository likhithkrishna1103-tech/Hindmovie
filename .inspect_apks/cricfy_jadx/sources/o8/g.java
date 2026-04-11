package o8;

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

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class g extends p8.a {
    public static final Parcelable.Creator<g> CREATOR = new l4.p(23);
    public static final Scope[] J = new Scope[0];
    public static final l8.d[] K = new l8.d[0];
    public Scope[] A;
    public Bundle B;
    public Account C;
    public l8.d[] D;
    public l8.d[] E;
    public final boolean F;
    public final int G;
    public final boolean H;
    public final String I;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f9659v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final int f9660w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final int f9661x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public String f9662y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public IBinder f9663z;

    public g(int i, int i10, int i11, String str, IBinder iBinder, Scope[] scopeArr, Bundle bundle, Account account, l8.d[] dVarArr, l8.d[] dVarArr2, boolean z10, int i12, boolean z11, String str2) {
        Scope[] scopeArr2 = scopeArr == null ? J : scopeArr;
        Bundle bundle2 = bundle == null ? new Bundle() : bundle;
        l8.d[] dVarArr3 = K;
        l8.d[] dVarArr4 = dVarArr == null ? dVarArr3 : dVarArr;
        dVarArr3 = dVarArr2 != null ? dVarArr2 : dVarArr3;
        this.f9659v = i;
        this.f9660w = i10;
        this.f9661x = i11;
        if ("com.google.android.gms".equals(str)) {
            this.f9662y = "com.google.android.gms";
        } else {
            this.f9662y = str;
        }
        if (i < 2) {
            Account account2 = null;
            if (iBinder != null) {
                int i13 = a.f9609e;
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
                h g0Var = iInterfaceQueryLocalInterface instanceof h ? (h) iInterfaceQueryLocalInterface : new g0(iBinder, "com.google.android.gms.common.internal.IAccountAccessor", 0);
                long jClearCallingIdentity = Binder.clearCallingIdentity();
                try {
                    try {
                        g0 g0Var2 = (g0) g0Var;
                        Parcel parcelB = g0Var2.b(g0Var2.f(), 2);
                        Account account3 = (Account) a9.j.a(parcelB, Account.CREATOR);
                        parcelB.recycle();
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
            this.C = account2;
        } else {
            this.f9663z = iBinder;
            this.C = account;
        }
        this.A = scopeArr2;
        this.B = bundle2;
        this.D = dVarArr4;
        this.E = dVarArr3;
        this.F = z10;
        this.G = i12;
        this.H = z11;
        this.I = str2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        l4.p.a(this, parcel, i);
    }
}
