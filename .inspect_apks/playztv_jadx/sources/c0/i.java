package c0;

import android.view.View;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Comparator;
import java.util.Map;
import java.util.WeakHashMap;
import q0.f0;
import q0.o0;
import q4.l;
import wa.t1;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class i implements Comparator {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f2227u;

    public /* synthetic */ i(int i) {
        this.f2227u = i;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        switch (this.f2227u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                WeakHashMap weakHashMap = o0.f10475a;
                float fG = f0.g((View) obj);
                float fG2 = f0.g((View) obj2);
                if (fG > fG2) {
                    return -1;
                }
                return fG < fG2 ? 1 : 0;
            case 1:
                return ((View) obj).getTop() - ((View) obj2).getTop();
            case 2:
                return ((k5.d) obj).f7020b - ((k5.d) obj2).f7020b;
            case 3:
                return Long.compare(((Long) obj).longValue(), ((Long) obj2).longValue());
            case b1.j.LONG_FIELD_NUMBER /* 4 */:
                l lVar = (l) obj;
                l lVar2 = (l) obj2;
                RecyclerView recyclerView = lVar.f10866d;
                if ((recyclerView == null) == (lVar2.f10866d == null)) {
                    boolean z2 = lVar.f10863a;
                    if (z2 == lVar2.f10863a) {
                        int i = lVar2.f10864b - lVar.f10864b;
                        if (i != 0) {
                            return i;
                        }
                        int i10 = lVar.f10865c - lVar2.f10865c;
                        if (i10 != 0) {
                            return i10;
                        }
                        return 0;
                    }
                    if (!z2) {
                        return 1;
                    }
                } else if (recyclerView == null) {
                    return 1;
                }
                return -1;
            case b1.j.STRING_FIELD_NUMBER /* 5 */:
                return ((v.f) obj).f13106v - ((v.f) obj2).f13106v;
            case b1.j.STRING_SET_FIELD_NUMBER /* 6 */:
                return t1.g((Integer) ((Map.Entry) obj).getKey(), (Integer) ((Map.Entry) obj2).getKey());
            case b1.j.DOUBLE_FIELD_NUMBER /* 7 */:
                return t1.g((Integer) ((Map.Entry) obj).getKey(), (Integer) ((Map.Entry) obj2).getKey());
            case 8:
                return t1.g(((w4.d) obj).f13719a, ((w4.d) obj2).f13719a);
            default:
                return t1.g(((w4.f) obj).f13730a, ((w4.f) obj2).f13730a);
        }
    }
}
