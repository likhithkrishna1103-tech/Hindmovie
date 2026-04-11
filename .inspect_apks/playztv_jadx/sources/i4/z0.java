package i4;

import android.content.Context;
import android.widget.FrameLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class z0 extends FrameLayout implements t0 {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final b f6353u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final x0 f6354v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public List f6355w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public c f6356x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public float f6357y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public float f6358z;

    public z0(Context context) {
        super(context, null);
        this.f6355w = Collections.EMPTY_LIST;
        this.f6356x = c.f6212g;
        this.f6357y = 0.0533f;
        this.f6358z = 0.08f;
        b bVar = new b(context, 0);
        this.f6353u = bVar;
        x0 x0Var = new x0(context, null);
        this.f6354v = x0Var;
        x0Var.setBackgroundColor(0);
        addView(bVar);
        addView(x0Var);
    }

    @Override // i4.t0
    public final void a(List list, c cVar, float f, float f4) {
        this.f6356x = cVar;
        this.f6357y = f;
        this.f6358z = f4;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            r1.b bVar = (r1.b) list.get(i);
            if (bVar.f11256d != null) {
                arrayList.add(bVar);
            } else {
                arrayList2.add(bVar);
            }
        }
        if (!this.f6355w.isEmpty() || !arrayList2.isEmpty()) {
            this.f6355w = arrayList2;
            c();
        }
        this.f6353u.a(arrayList, cVar, f, f4);
        invalidate();
    }

    public final String b(int i, float f) {
        float fA = z7.a.A(i, f, getHeight(), (getHeight() - getPaddingTop()) - getPaddingBottom());
        if (fA == -3.4028235E38f) {
            return "unset";
        }
        Object[] objArr = {Float.valueOf(fA / getContext().getResources().getDisplayMetrics().density)};
        int i10 = s1.b0.f11647a;
        return String.format(Locale.US, "%.2fpx", objArr);
    }

    /* JADX WARN: Removed duplicated region for block: B:193:0x0499  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x04bf  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x0514  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x05ed  */
    /* JADX WARN: Removed duplicated region for block: B:264:0x0629  */
    /* JADX WARN: Removed duplicated region for block: B:271:0x064e  */
    /* JADX WARN: Removed duplicated region for block: B:274:0x069d  */
    /* JADX WARN: Removed duplicated region for block: B:282:0x06cf  */
    /* JADX WARN: Removed duplicated region for block: B:300:0x0546 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x017b  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01dd  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0203  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x020f  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0239  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0250  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c() {
        /*
            Method dump skipped, instruction units count: 1862
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: i4.z0.c():void");
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z2, int i, int i10, int i11, int i12) {
        super.onLayout(z2, i, i10, i11, i12);
        if (!z2 || this.f6355w.isEmpty()) {
            return;
        }
        c();
    }
}
