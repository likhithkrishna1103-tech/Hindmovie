package androidx.emoji2.text;

import androidx.media3.decoder.DecoderInputBuffer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class k implements Runnable {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f859v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final int f860w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Object f861x;

    public /* synthetic */ k(int i, int i10, Object obj) {
        this.f859v = i10;
        this.f861x = obj;
        this.f860w = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f859v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                ArrayList arrayList = (ArrayList) this.f861x;
                int size = arrayList.size();
                int i = 0;
                if (this.f860w == 1) {
                    while (i < size) {
                        ((j) arrayList.get(i)).b();
                        i++;
                    }
                } else {
                    while (i < size) {
                        ((j) arrayList.get(i)).a();
                        i++;
                    }
                }
                break;
            case 1:
                ((com.google.android.material.datepicker.m) this.f861x).f2872z0.j0(this.f860w);
                break;
            case 2:
                ((n8.i) this.f861x).i(this.f860w);
                break;
            default:
                k0.b bVar = (k0.b) ((kf.i) this.f861x).f7483w;
                if (bVar != null) {
                    bVar.h(this.f860w);
                }
                break;
        }
    }

    public k(List list, int i, Throwable th) {
        this.f859v = 0;
        com.bumptech.glide.f.f(list, "initCallbacks cannot be null");
        this.f861x = new ArrayList(list);
        this.f860w = i;
    }
}
