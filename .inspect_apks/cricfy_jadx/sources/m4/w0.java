package m4;

import android.content.Context;
import android.widget.FrameLayout;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class w0 extends FrameLayout implements q0 {
    public float A;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final b f8294v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final u0 f8295w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public List f8296x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public c f8297y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public float f8298z;

    public w0(Context context) {
        super(context, null);
        this.f8296x = Collections.EMPTY_LIST;
        this.f8297y = c.f8162g;
        this.f8298z = 0.0533f;
        this.A = 0.08f;
        b bVar = new b(context, 0);
        this.f8294v = bVar;
        u0 u0Var = new u0(context, null);
        this.f8295w = u0Var;
        u0Var.setBackgroundColor(0);
        addView(bVar);
        addView(u0Var);
    }

    @Override // m4.q0
    public final void a(List list, c cVar, float f, float f10) {
        this.f8297y = cVar;
        this.f8298z = f;
        this.A = f10;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            x1.b bVar = (x1.b) list.get(i);
            if (bVar.f14252d != null) {
                arrayList.add(bVar);
            } else {
                arrayList2.add(bVar);
            }
        }
        if (!this.f8296x.isEmpty() || !arrayList2.isEmpty()) {
            this.f8296x = arrayList2;
            c();
        }
        this.f8294v.a(arrayList, cVar, f, f10);
        invalidate();
    }

    public final String b(int i, float f) {
        float fT = w1.d.t(i, f, getHeight(), (getHeight() - getPaddingTop()) - getPaddingBottom());
        if (fT == -3.4028235E38f) {
            return "unset";
        }
        Object[] objArr = {Float.valueOf(fT / getContext().getResources().getDisplayMetrics().density)};
        int i10 = y1.a0.f14551a;
        return String.format(Locale.US, "%.2fpx", objArr);
    }

    /* JADX WARN: Multi-variable type inference failed */
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
    /* JADX WARN: Type inference failed for: r36v0 */
    /* JADX WARN: Type inference failed for: r9v24 */
    /* JADX WARN: Type inference failed for: r9v25 */
    /* JADX WARN: Type inference failed for: r9v27 */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v5 */
    /* JADX WARN: Type inference failed for: r9v6 */
    /* JADX WARN: Type inference failed for: r9v7 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c() {
        /*
            Method dump skipped, instruction units count: 1862
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m4.w0.c():void");
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z10, int i, int i10, int i11, int i12) {
        super.onLayout(z10, i, i10, i11, i12);
        if (!z10 || this.f8296x.isEmpty()) {
            return;
        }
        c();
    }
}
