package v2;

import g2.o1;
import java.util.Objects;
import v1.n1;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f13128a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o1[] f13129b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final q[] f13130c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final n1 f13131d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Object f13132e;

    public u(o1[] o1VarArr, q[] qVarArr, n1 n1Var, Object obj) {
        y1.d.b(o1VarArr.length == qVarArr.length);
        this.f13129b = o1VarArr;
        this.f13130c = (q[]) qVarArr.clone();
        this.f13131d = n1Var;
        this.f13132e = obj;
        this.f13128a = o1VarArr.length;
    }

    public final boolean a(u uVar, int i) {
        return uVar != null && Objects.equals(this.f13129b[i], uVar.f13129b[i]) && Objects.equals(this.f13130c[i], uVar.f13130c[i]);
    }

    public final boolean b(int i) {
        return this.f13129b[i] != null;
    }
}
