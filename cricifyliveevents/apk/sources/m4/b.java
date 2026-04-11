package m4;

import android.content.Context;
import android.view.View;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b extends View implements q0 {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final ArrayList f8157v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public List f8158w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public float f8159x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public c f8160y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public float f8161z;

    public b(Context context, int i) {
        super(context, null);
        this.f8157v = new ArrayList();
        this.f8158w = Collections.EMPTY_LIST;
        this.f8159x = 0.0533f;
        this.f8160y = c.f8162g;
        this.f8161z = 0.08f;
    }

    @Override // m4.q0
    public final void a(List list, c cVar, float f, float f10) {
        this.f8158w = list;
        this.f8160y = cVar;
        this.f8159x = f;
        this.f8161z = f10;
        while (true) {
            ArrayList arrayList = this.f8157v;
            if (arrayList.size() >= list.size()) {
                invalidate();
                return;
            }
            arrayList.add(new p0(getContext()));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:187:0x0466  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0469  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0103  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void dispatchDraw(android.graphics.Canvas r37) {
        /*
            Method dump skipped, instruction units count: 1176
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: m4.b.dispatchDraw(android.graphics.Canvas):void");
    }
}
