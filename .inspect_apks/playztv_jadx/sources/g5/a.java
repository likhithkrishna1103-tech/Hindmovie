package g5;

import android.animation.TimeInterpolator;
import android.util.AndroidRuntimeException;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a extends p {
    public int W;
    public ArrayList U = new ArrayList();
    public boolean V = true;
    public boolean X = false;
    public int Y = 0;

    public a() {
        L(1);
        I(new h(2));
        I(new f());
        I(new h(1));
    }

    @Override // g5.p
    public final void B(android.support.v4.media.session.b bVar) {
        this.Y |= 8;
        int size = this.U.size();
        for (int i = 0; i < size; i++) {
            ((p) this.U.get(i)).B(bVar);
        }
    }

    @Override // g5.p
    public final void D(t7.j jVar) {
        super.D(jVar);
        this.Y |= 4;
        if (this.U != null) {
            for (int i = 0; i < this.U.size(); i++) {
                ((p) this.U.get(i)).D(jVar);
            }
        }
    }

    @Override // g5.p
    public final void E() {
        this.Y |= 2;
        int size = this.U.size();
        for (int i = 0; i < size; i++) {
            ((p) this.U.get(i)).E();
        }
    }

    @Override // g5.p
    public final void F(long j5) {
        this.f5299v = j5;
    }

    @Override // g5.p
    public final String H(String str) {
        String strH = super.H(str);
        for (int i = 0; i < this.U.size(); i++) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(strH);
            sb2.append("\n");
            sb2.append(((p) this.U.get(i)).H(str + "  "));
            strH = sb2.toString();
        }
        return strH;
    }

    public final void I(p pVar) {
        this.U.add(pVar);
        pVar.C = this;
        long j5 = this.f5300w;
        if (j5 >= 0) {
            pVar.A(j5);
        }
        if ((this.Y & 1) != 0) {
            pVar.C(this.f5301x);
        }
        if ((this.Y & 2) != 0) {
            pVar.E();
        }
        if ((this.Y & 4) != 0) {
            pVar.D(this.P);
        }
        if ((this.Y & 8) != 0) {
            pVar.B(null);
        }
    }

    @Override // g5.p
    /* JADX INFO: renamed from: J, reason: merged with bridge method [inline-methods] */
    public final void A(long j5) {
        ArrayList arrayList;
        this.f5300w = j5;
        if (j5 < 0 || (arrayList = this.U) == null) {
            return;
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ((p) this.U.get(i)).A(j5);
        }
    }

    @Override // g5.p
    /* JADX INFO: renamed from: K, reason: merged with bridge method [inline-methods] */
    public final void C(TimeInterpolator timeInterpolator) {
        this.Y |= 1;
        ArrayList arrayList = this.U;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                ((p) this.U.get(i)).C(timeInterpolator);
            }
        }
        this.f5301x = timeInterpolator;
    }

    public final void L(int i) {
        if (i == 0) {
            this.V = true;
        } else {
            if (i != 1) {
                throw new AndroidRuntimeException(e6.j.l("Invalid parameter for TransitionSet ordering: ", i));
            }
            this.V = false;
        }
    }

    @Override // g5.p
    public final void c() {
        super.c();
        int size = this.U.size();
        for (int i = 0; i < size; i++) {
            ((p) this.U.get(i)).c();
        }
    }

    @Override // g5.p
    public final void d(x xVar) {
        View view = xVar.f5315b;
        if (t(view)) {
            ArrayList arrayList = this.U;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                p pVar = (p) obj;
                if (pVar.t(view)) {
                    pVar.d(xVar);
                    xVar.f5316c.add(pVar);
                }
            }
        }
    }

    @Override // g5.p
    public final void f(x xVar) {
        int size = this.U.size();
        for (int i = 0; i < size; i++) {
            ((p) this.U.get(i)).f(xVar);
        }
    }

    @Override // g5.p
    public final void g(x xVar) {
        View view = xVar.f5315b;
        if (t(view)) {
            ArrayList arrayList = this.U;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                p pVar = (p) obj;
                if (pVar.t(view)) {
                    pVar.g(xVar);
                    xVar.f5316c.add(pVar);
                }
            }
        }
    }

    @Override // g5.p
    /* JADX INFO: renamed from: j */
    public final p clone() {
        a aVar = (a) super.clone();
        aVar.U = new ArrayList();
        int size = this.U.size();
        for (int i = 0; i < size; i++) {
            p pVarClone = ((p) this.U.get(i)).clone();
            aVar.U.add(pVarClone);
            pVarClone.C = aVar;
        }
        return aVar;
    }

    @Override // g5.p
    public final void l(ViewGroup viewGroup, ub.o oVar, ub.o oVar2, ArrayList arrayList, ArrayList arrayList2) {
        long j5 = this.f5299v;
        int size = this.U.size();
        for (int i = 0; i < size; i++) {
            p pVar = (p) this.U.get(i);
            if (j5 > 0 && (this.V || i == 0)) {
                long j8 = pVar.f5299v;
                if (j8 > 0) {
                    pVar.F(j8 + j5);
                } else {
                    pVar.F(j5);
                }
            }
            pVar.l(viewGroup, oVar, oVar2, arrayList, arrayList2);
        }
    }

    @Override // g5.p
    public final void w(View view) {
        super.w(view);
        int size = this.U.size();
        for (int i = 0; i < size; i++) {
            ((p) this.U.get(i)).w(view);
        }
    }

    @Override // g5.p
    public final p x(n nVar) {
        super.x(nVar);
        return this;
    }

    @Override // g5.p
    public final void y(View view) {
        super.y(view);
        int size = this.U.size();
        for (int i = 0; i < size; i++) {
            ((p) this.U.get(i)).y(view);
        }
    }

    @Override // g5.p
    public final void z() {
        if (this.U.isEmpty()) {
            G();
            m();
            return;
        }
        u uVar = new u();
        uVar.f5312b = this;
        ArrayList arrayList = this.U;
        int size = arrayList.size();
        int i = 0;
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayList.get(i10);
            i10++;
            ((p) obj).a(uVar);
        }
        this.W = this.U.size();
        if (this.V) {
            ArrayList arrayList2 = this.U;
            int size2 = arrayList2.size();
            while (i < size2) {
                Object obj2 = arrayList2.get(i);
                i++;
                ((p) obj2).z();
            }
            return;
        }
        for (int i11 = 1; i11 < this.U.size(); i11++) {
            ((p) this.U.get(i11 - 1)).a(new u((p) this.U.get(i11)));
        }
        p pVar = (p) this.U.get(0);
        if (pVar != null) {
            pVar.z();
        }
    }
}
