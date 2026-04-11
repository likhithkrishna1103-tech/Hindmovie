package ka;

import android.graphics.Canvas;
import android.graphics.Matrix;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class o extends u {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ArrayList f7361c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Matrix f7362d;

    public o(ArrayList arrayList, Matrix matrix) {
        this.f7361c = arrayList;
        this.f7362d = matrix;
    }

    @Override // ka.u
    public final void a(Matrix matrix, ja.a aVar, int i, Canvas canvas) {
        ArrayList arrayList = this.f7361c;
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayList.get(i10);
            i10++;
            ((u) obj).a(this.f7362d, aVar, i, canvas);
        }
    }
}
