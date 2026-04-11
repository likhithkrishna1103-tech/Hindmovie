package a5;

import android.view.View;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Comparator;
import java.util.Map;
import java.util.WeakHashMap;
import t0.d0;
import t0.m0;
import v4.k;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class f implements Comparator {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final /* synthetic */ f f276w = new f(6);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f277v;

    public /* synthetic */ f(int i) {
        this.f277v = i;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        switch (this.f277v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return sd.i.e((Integer) ((Map.Entry) obj).getKey(), (Integer) ((Map.Entry) obj2).getKey());
            case 1:
                return sd.i.e((Integer) ((Map.Entry) obj).getKey(), (Integer) ((Map.Entry) obj2).getKey());
            case 2:
                return sd.i.e(((g) obj).f278a, ((g) obj2).f278a);
            case 3:
                return sd.i.e(((i) obj).f289a, ((i) obj2).f289a);
            case g1.h.LONG_FIELD_NUMBER /* 4 */:
                return ((View) obj).getTop() - ((View) obj2).getTop();
            case g1.h.STRING_FIELD_NUMBER /* 5 */:
                WeakHashMap weakHashMap = m0.f11777a;
                float fG = d0.g((View) obj);
                float fG2 = d0.g((View) obj2);
                if (fG > fG2) {
                    return -1;
                }
                return fG < fG2 ? 1 : 0;
            case g1.h.STRING_SET_FIELD_NUMBER /* 6 */:
                return Long.compare(((Long) obj).longValue(), ((Long) obj2).longValue());
            case g1.h.DOUBLE_FIELD_NUMBER /* 7 */:
                return ((p5.c) obj).f9992b - ((p5.c) obj2).f9992b;
            case g1.h.BYTES_FIELD_NUMBER /* 8 */:
                k kVar = (k) obj;
                k kVar2 = (k) obj2;
                RecyclerView recyclerView = kVar.f13292d;
                if ((recyclerView == null) == (kVar2.f13292d == null)) {
                    boolean z10 = kVar.f13289a;
                    if (z10 == kVar2.f13289a) {
                        int i = kVar2.f13290b - kVar.f13290b;
                        if (i != 0) {
                            return i;
                        }
                        int i10 = kVar.f13291c - kVar2.f13291c;
                        if (i10 != 0) {
                            return i10;
                        }
                        return 0;
                    }
                    if (!z10) {
                        return 1;
                    }
                } else if (recyclerView == null) {
                    return 1;
                }
                return -1;
            default:
                return ((y.f) obj).f14539w - ((y.f) obj2).f14539w;
        }
    }
}
