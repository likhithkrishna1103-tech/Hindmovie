package oa;

import androidx.media3.decoder.DecoderInputBuffer;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class l implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9736a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f9737b;

    public /* synthetic */ l(int i, Object obj) {
        this.f9736a = i;
        this.f9737b = obj;
    }

    @Override // oa.d
    public final void a(h hVar) {
        switch (this.f9736a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                ((p5.g) this.f9737b).setCurrentItem(hVar.f9722b);
                break;
            default:
                x5.i iVar = (x5.i) this.f9737b;
                String string = hVar.f9721a.toString();
                if (!"All".equals(string)) {
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = iVar.f14350w0;
                    int size = arrayList2.size();
                    int i = 0;
                    while (i < size) {
                        Object obj = arrayList2.get(i);
                        i++;
                        y5.c cVar = (y5.c) obj;
                        String str = cVar.f14917e;
                        if (str != null && str.equals(string)) {
                            arrayList.add(cVar);
                        }
                    }
                    iVar.f14349v0.h(arrayList);
                } else {
                    iVar.f14349v0.h(iVar.f14350w0);
                }
                break;
        }
    }
}
