package nc;

import androidx.media3.decoder.DecoderInputBuffer;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class k implements u9.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8942a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f8943b;

    public /* synthetic */ k(int i, Object obj) {
        this.f8942a = i;
        this.f8943b = obj;
    }

    @Override // u9.c
    public final void a(u9.g gVar) {
        switch (this.f8942a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                m mVar = (m) this.f8943b;
                mVar.B0 = gVar.f12804b;
                String string = gVar.f12803a.toString();
                if (!"All".equals(string)) {
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = mVar.f8946v0;
                    int size = arrayList2.size();
                    int i = 0;
                    while (i < size) {
                        Object obj = arrayList2.get(i);
                        i++;
                        oc.c cVar = (oc.c) obj;
                        String str = cVar.f9519e;
                        if (str != null && str.equals(string)) {
                            arrayList.add(cVar);
                        }
                    }
                    mVar.f8945u0.g(arrayList);
                } else {
                    mVar.f8945u0.g(mVar.f8946v0);
                }
                break;
            default:
                ((k5.i) this.f8943b).setCurrentItem(gVar.f12804b);
                break;
        }
    }
}
