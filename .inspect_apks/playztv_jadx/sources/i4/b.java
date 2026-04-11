package i4;

import android.content.Context;
import android.view.View;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b extends View implements t0 {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final ArrayList f6207u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public List f6208v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public float f6209w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public c f6210x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public float f6211y;

    public b(Context context, int i) {
        super(context, null);
        this.f6207u = new ArrayList();
        this.f6208v = Collections.EMPTY_LIST;
        this.f6209w = 0.0533f;
        this.f6210x = c.f6212g;
        this.f6211y = 0.08f;
    }

    @Override // i4.t0
    public final void a(List list, c cVar, float f, float f4) {
        this.f6208v = list;
        this.f6210x = cVar;
        this.f6209w = f;
        this.f6211y = f4;
        while (true) {
            ArrayList arrayList = this.f6207u;
            if (arrayList.size() >= list.size()) {
                invalidate();
                return;
            }
            arrayList.add(new s0(getContext()));
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
        throw new UnsupportedOperationException("Method not decompiled: i4.b.dispatchDraw(android.graphics.Canvas):void");
    }
}
