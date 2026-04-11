package vc;

import android.content.Context;
import androidx.media3.decoder.DecoderInputBuffer;
import java.io.File;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class p implements fe.a {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f13673v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ Context f13674w;

    public /* synthetic */ p(Context context, int i) {
        this.f13673v = i;
        this.f13674w = context;
    }

    @Override // fe.a
    public final Object b() throws IOException {
        switch (this.f13673v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                File fileE = ab.b.e(this.f13674w, "firebaseSessions/sessionConfigsDataStore.data");
                q.c(fileE);
                return fileE;
            default:
                File fileE2 = ab.b.e(this.f13674w, "firebaseSessions/sessionDataStore.data");
                q.c(fileE2);
                return fileE2;
        }
    }
}
