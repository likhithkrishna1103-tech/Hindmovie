package l5;

import android.animation.TimeInterpolator;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a extends n {
    public ArrayList V;
    public boolean W;
    public int X;
    public boolean Y;
    public int Z;

    @Override // l5.n
    public final void A(long j4) {
        ArrayList arrayList;
        this.f7816x = j4;
        if (j4 < 0 || (arrayList = this.V) == null) {
            return;
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ((n) this.V.get(i)).A(j4);
        }
    }

    @Override // l5.n
    public final void B(a.a aVar) {
        this.Z |= 8;
        int size = this.V.size();
        for (int i = 0; i < size; i++) {
            ((n) this.V.get(i)).B(aVar);
        }
    }

    @Override // l5.n
    public final void C(TimeInterpolator timeInterpolator) {
        this.Z |= 1;
        ArrayList arrayList = this.V;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                ((n) this.V.get(i)).C(timeInterpolator);
            }
        }
        this.f7817y = timeInterpolator;
    }

    @Override // l5.n
    public final void D(f9.z zVar) {
        super.D(zVar);
        this.Z |= 4;
        if (this.V != null) {
            for (int i = 0; i < this.V.size(); i++) {
                ((n) this.V.get(i)).D(zVar);
            }
        }
    }

    @Override // l5.n
    public final void E() {
        this.Z |= 2;
        int size = this.V.size();
        for (int i = 0; i < size; i++) {
            ((n) this.V.get(i)).E();
        }
    }

    @Override // l5.n
    public final void F(long j4) {
        this.f7815w = j4;
    }

    @Override // l5.n
    public final String H(String str) {
        String strH = super.H(str);
        for (int i = 0; i < this.V.size(); i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(strH);
            sb.append("\n");
            sb.append(((n) this.V.get(i)).H(str + "  "));
            strH = sb.toString();
        }
        return strH;
    }

    public final void I(n nVar) {
        this.V.add(nVar);
        nVar.D = this;
        long j4 = this.f7816x;
        if (j4 >= 0) {
            nVar.A(j4);
        }
        if ((this.Z & 1) != 0) {
            nVar.C(this.f7817y);
        }
        if ((this.Z & 2) != 0) {
            nVar.E();
        }
        if ((this.Z & 4) != 0) {
            nVar.D(this.Q);
        }
        if ((this.Z & 8) != 0) {
            nVar.B(null);
        }
    }

    @Override // l5.n
    public final void c() {
        super.c();
        int size = this.V.size();
        for (int i = 0; i < size; i++) {
            ((n) this.V.get(i)).c();
        }
    }

    @Override // l5.n
    public final void d(v vVar) {
        View view = vVar.f7830b;
        if (t(view)) {
            ArrayList arrayList = this.V;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                n nVar = (n) obj;
                if (nVar.t(view)) {
                    nVar.d(vVar);
                    vVar.f7831c.add(nVar);
                }
            }
        }
    }

    @Override // l5.n
    public final void f(v vVar) {
        int size = this.V.size();
        for (int i = 0; i < size; i++) {
            ((n) this.V.get(i)).f(vVar);
        }
    }

    @Override // l5.n
    public final void g(v vVar) {
        View view = vVar.f7830b;
        if (t(view)) {
            ArrayList arrayList = this.V;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                n nVar = (n) obj;
                if (nVar.t(view)) {
                    nVar.g(vVar);
                    vVar.f7831c.add(nVar);
                }
            }
        }
    }

    @Override // l5.n
    /* JADX INFO: renamed from: j */
    public final n clone() {
        a aVar = (a) super.clone();
        aVar.V = new ArrayList();
        int size = this.V.size();
        for (int i = 0; i < size; i++) {
            n nVarClone = ((n) this.V.get(i)).clone();
            aVar.V.add(nVarClone);
            nVarClone.D = aVar;
        }
        return aVar;
    }

    @Override // l5.n
    public final void l(ViewGroup viewGroup, b6.f fVar, b6.f fVar2, ArrayList arrayList, ArrayList arrayList2) {
        long j4 = this.f7815w;
        int size = this.V.size();
        for (int i = 0; i < size; i++) {
            n nVar = (n) this.V.get(i);
            if (j4 > 0 && (this.W || i == 0)) {
                long j7 = nVar.f7815w;
                if (j7 > 0) {
                    nVar.F(j7 + j4);
                } else {
                    nVar.F(j4);
                }
            }
            nVar.l(viewGroup, fVar, fVar2, arrayList, arrayList2);
        }
    }

    @Override // l5.n
    public final void w(View view) {
        super.w(view);
        int size = this.V.size();
        for (int i = 0; i < size; i++) {
            ((n) this.V.get(i)).w(view);
        }
    }

    @Override // l5.n
    public final n x(l lVar) {
        super.x(lVar);
        return this;
    }

    @Override // l5.n
    public final void y(View view) {
        super.y(view);
        int size = this.V.size();
        for (int i = 0; i < size; i++) {
            ((n) this.V.get(i)).y(view);
        }
    }

    @Override // l5.n
    public final void z() {
        if (this.V.isEmpty()) {
            G();
            m();
            return;
        }
        s sVar = new s();
        sVar.f7827b = this;
        ArrayList arrayList = this.V;
        int size = arrayList.size();
        int i = 0;
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayList.get(i10);
            i10++;
            ((n) obj).a(sVar);
        }
        this.X = this.V.size();
        if (this.W) {
            ArrayList arrayList2 = this.V;
            int size2 = arrayList2.size();
            while (i < size2) {
                Object obj2 = arrayList2.get(i);
                i++;
                ((n) obj2).z();
            }
            return;
        }
        for (int i11 = 1; i11 < this.V.size(); i11++) {
            ((n) this.V.get(i11 - 1)).a(new s((n) this.V.get(i11)));
        }
        n nVar = (n) this.V.get(0);
        if (nVar != null) {
            nVar.z();
        }
    }
}
