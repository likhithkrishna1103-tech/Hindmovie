package j2;

import androidx.media3.decoder.DecoderInputBuffer;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class t implements Comparator {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f6754u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ Object f6755v;

    public /* synthetic */ t(int i, Object obj) {
        this.f6754u = i;
        this.f6755v = obj;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        switch (this.f6754u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                x xVar = (x) this.f6755v;
                return xVar.f(obj2) - xVar.f(obj);
            default:
                List list = (List) this.f6755v;
                int iIndexOf = list.indexOf(((oc.d) obj).f9521a);
                int iIndexOf2 = list.indexOf(((oc.d) obj2).f9521a);
                if (iIndexOf == -1) {
                    iIndexOf = Integer.MAX_VALUE;
                }
                if (iIndexOf2 == -1) {
                    iIndexOf2 = Integer.MAX_VALUE;
                }
                return Integer.compare(iIndexOf, iIndexOf2);
        }
    }
}
