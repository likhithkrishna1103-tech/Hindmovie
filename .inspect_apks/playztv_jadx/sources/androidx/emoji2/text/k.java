package androidx.emoji2.text;

import androidx.media3.decoder.DecoderInputBuffer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class k implements Runnable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f1177u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f1178v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Object f1179w;

    public /* synthetic */ k(int i, int i10, Object obj) {
        this.f1177u = i10;
        this.f1179w = obj;
        this.f1178v = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1177u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                ArrayList arrayList = (ArrayList) this.f1179w;
                int size = arrayList.size();
                int i = 0;
                if (this.f1178v == 1) {
                    while (i < size) {
                        ((j) arrayList.get(i)).a();
                        i++;
                    }
                } else {
                    while (i < size) {
                        ((j) arrayList.get(i)).getClass();
                        i++;
                    }
                }
                break;
            case 1:
                ((com.google.android.material.datepicker.m) this.f1179w).f3416y0.j0(this.f1178v);
                break;
            case 2:
                ((l9.e) this.f1179w).i(this.f1178v);
                break;
            case 3:
                h0.b bVar = (h0.b) ((wb.c) this.f1179w).f14088v;
                if (bVar != null) {
                    bVar.h(this.f1178v);
                }
                break;
            default:
                ((s7.j) this.f1179w).i(this.f1178v);
                break;
        }
    }

    public k(List list, int i, Throwable th) {
        this.f1177u = 0;
        cf.l.j(list, "initCallbacks cannot be null");
        this.f1179w = new ArrayList(list);
        this.f1178v = i;
    }
}
