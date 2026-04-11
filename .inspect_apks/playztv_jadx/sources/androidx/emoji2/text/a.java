package androidx.emoji2.text;

import androidx.media3.decoder.DecoderInputBuffer;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements ThreadFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1164a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f1165b;

    public /* synthetic */ a(String str, int i) {
        this.f1164a = i;
        this.f1165b = str;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        switch (this.f1164a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                Thread thread = new Thread(runnable, this.f1165b);
                thread.setPriority(10);
                return thread;
            default:
                return new Thread(runnable, this.f1165b);
        }
    }
}
