package sd;

import com.google.android.gms.internal.measurement.j4;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c extends d implements RandomAccess {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final d f11657v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final int f11658w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final int f11659x;

    public c(d dVar, int i, int i10) {
        this.f11657v = dVar;
        this.f11658w = i;
        j4.b(i, i10, dVar.a());
        this.f11659x = i10 - i;
    }

    @Override // sd.a
    public final int a() {
        return this.f11659x;
    }

    @Override // java.util.List
    public final Object get(int i) {
        int i10 = this.f11659x;
        if (i < 0 || i >= i10) {
            throw new IndexOutOfBoundsException(q4.a.m(i, i10, "index: ", ", size: "));
        }
        return this.f11657v.get(this.f11658w + i);
    }

    @Override // sd.d, java.util.List
    public final List subList(int i, int i10) {
        j4.b(i, i10, this.f11659x);
        int i11 = this.f11658w;
        return new c(this.f11657v, i + i11, i11 + i10);
    }
}
