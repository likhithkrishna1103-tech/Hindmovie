package w0;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class d extends FrameLayout {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final Object f13766x = new Object();

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final ArrayList f13767v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public c f13768w;

    public d(Context context, List list) {
        super(context);
        this.f13767v = new ArrayList();
        setProtections(list);
    }

    private g getOrInstallSystemBarStateMonitor() {
        ViewGroup viewGroup = (ViewGroup) getRootView();
        Object tag = viewGroup.getTag(g0.c.tag_system_bar_state_monitor);
        if (tag instanceof g) {
            return (g) tag;
        }
        g gVar = new g(viewGroup);
        viewGroup.setTag(g0.c.tag_system_bar_state_monitor, gVar);
        return gVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00b0 A[LOOP:0: B:6:0x0023->B:26:0x00b0, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00b9 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a() {
        /*
            r13 = this;
            java.util.ArrayList r0 = r13.f13767v
            boolean r1 = r0.isEmpty()
            if (r1 == 0) goto La
            goto Lc1
        La:
            w0.g r1 = r13.getOrInstallSystemBarStateMonitor()
            w0.c r2 = new w0.c
            r2.<init>(r1, r0)
            r13.f13768w = r2
            int r0 = r13.getChildCount()
            w0.c r1 = r13.f13768w
            java.util.ArrayList r1 = r1.f13761a
            int r1 = r1.size()
            r2 = 0
            r3 = r2
        L23:
            if (r3 >= r1) goto Lc1
            w0.c r4 = r13.f13768w
            java.util.ArrayList r4 = r4.f13761a
            java.lang.Object r4 = r4.get(r3)
            w0.a r4 = (w0.a) r4
            android.content.Context r5 = r13.getContext()
            int r6 = r3 + r0
            w0.b r7 = r4.f13748b
            int r4 = r4.f13747a
            r8 = 1
            r9 = 4
            r10 = -1
            if (r4 == r8) goto L64
            r8 = 2
            if (r4 == r8) goto L5f
            if (r4 == r9) goto L58
            r8 = 8
            if (r4 != r8) goto L4c
            int r4 = r7.f13755b
            r8 = 80
            goto L68
        L4c:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Unexpected side: "
            java.lang.String r1 = l0.e.g(r4, r1)
            r0.<init>(r1)
            throw r0
        L58:
            int r4 = r7.f13754a
            r8 = 5
        L5b:
            r12 = r10
            r10 = r4
            r4 = r12
            goto L68
        L5f:
            int r4 = r7.f13755b
            r8 = 48
            goto L68
        L64:
            int r4 = r7.f13754a
            r8 = 3
            goto L5b
        L68:
            android.widget.FrameLayout$LayoutParams r11 = new android.widget.FrameLayout$LayoutParams
            r11.<init>(r10, r4, r8)
            l0.c r4 = r7.f13756c
            int r8 = r4.f7602a
            r11.leftMargin = r8
            int r8 = r4.f7603b
            r11.topMargin = r8
            int r8 = r4.f7604c
            r11.rightMargin = r8
            int r4 = r4.f7605d
            r11.bottomMargin = r4
            android.view.View r4 = new android.view.View
            r4.<init>(r5)
            java.lang.Object r5 = w0.d.f13766x
            r4.setTag(r5)
            float r5 = r7.f
            r4.setTranslationX(r5)
            float r5 = r7.f13759g
            r4.setTranslationY(r5)
            float r5 = r7.f13760h
            r4.setAlpha(r5)
            boolean r5 = r7.f13757d
            if (r5 == 0) goto L9d
            r9 = r2
        L9d:
            r4.setVisibility(r9)
            android.graphics.drawable.ColorDrawable r5 = r7.f13758e
            r4.setBackground(r5)
            vb.b r5 = new vb.b
            r8 = 1
            r9 = 0
            r5.<init>(r8, r11, r4, r9)
            vb.b r8 = r7.i
            if (r8 != 0) goto Lb9
            r7.i = r5
            r13.addView(r4, r6, r11)
            int r3 = r3 + 1
            goto L23
        Lb9:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Trying to overwrite the existing callback. Did you send one protection to multiple ProtectionLayouts?"
            r0.<init>(r1)
            throw r0
        Lc1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: w0.d.a():void");
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (view != null && view.getTag() != f13766x) {
            c cVar = this.f13768w;
            int childCount = getChildCount() - (cVar != null ? cVar.f13761a.size() : 0);
            if (i > childCount || i < 0) {
                i = childCount;
            }
        }
        super.addView(view, i, layoutParams);
    }

    public final void b() {
        if (this.f13768w != null) {
            removeViews(getChildCount() - this.f13768w.f13761a.size(), this.f13768w.f13761a.size());
            int size = this.f13768w.f13761a.size();
            for (int i = 0; i < size; i++) {
                ((a) this.f13768w.f13761a.get(i)).f13748b.i = null;
            }
            c cVar = this.f13768w;
            ArrayList arrayList = cVar.f13761a;
            if (!cVar.f) {
                cVar.f = true;
                cVar.f13762b.f13774b.remove(cVar);
                for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                    ((a) arrayList.get(size2)).f13751e = null;
                }
                arrayList.clear();
            }
            this.f13768w = null;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f13768w != null) {
            b();
        }
        a();
        requestApplyInsets();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        b();
        ViewGroup viewGroup = (ViewGroup) getRootView();
        Object tag = viewGroup.getTag(g0.c.tag_system_bar_state_monitor);
        if (tag instanceof g) {
            g gVar = (g) tag;
            if (gVar.f13774b.isEmpty()) {
                gVar.f13773a.post(new pa.c(11, gVar));
                viewGroup.setTag(g0.c.tag_system_bar_state_monitor, null);
            }
        }
    }

    public void setProtections(List<a> list) {
        ArrayList arrayList = this.f13767v;
        arrayList.clear();
        arrayList.addAll(list);
        if (isAttachedToWindow()) {
            b();
            a();
            requestApplyInsets();
        }
    }
}
