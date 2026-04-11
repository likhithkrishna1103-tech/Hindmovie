package q9;

import android.graphics.Canvas;
import android.graphics.Matrix;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class m extends s {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ArrayList f11134c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Matrix f11135d;

    public m(ArrayList arrayList, Matrix matrix) {
        this.f11134c = arrayList;
        this.f11135d = matrix;
    }

    @Override // q9.s
    public final void a(Matrix matrix, p9.a aVar, int i, Canvas canvas) {
        ArrayList arrayList = this.f11134c;
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayList.get(i10);
            i10++;
            ((s) obj).a(this.f11135d, aVar, i, canvas);
        }
    }
}
