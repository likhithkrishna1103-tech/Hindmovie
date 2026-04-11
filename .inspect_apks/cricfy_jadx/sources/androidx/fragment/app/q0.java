package androidx.fragment.app;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class q0 implements p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1040a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f1041b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ r0 f1042c;

    public q0(r0 r0Var, String str, int i) {
        this.f1042c = r0Var;
        this.f1040a = str;
        this.f1041b = i;
    }

    @Override // androidx.fragment.app.p0
    public final boolean a(ArrayList arrayList, ArrayList arrayList2) {
        r0 r0Var = this.f1042c;
        y yVar = r0Var.f1065x;
        if (yVar != null && this.f1041b < 0 && this.f1040a == null && yVar.i().S(-1, 0)) {
            return false;
        }
        return r0Var.T(arrayList, arrayList2, this.f1040a, this.f1041b, 1);
    }
}
