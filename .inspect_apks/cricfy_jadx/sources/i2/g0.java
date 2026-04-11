package i2;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioTrack;
import android.os.Build;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g0 f6042a = new g0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final g0 f6043b = new g0();

    public AudioTrack a(m mVar, v1.c cVar, int i, Context context) {
        int i10 = Build.VERSION.SDK_INT;
        int i11 = mVar.f6094b;
        int i12 = mVar.f6095c;
        int i13 = mVar.f6093a;
        int i14 = y1.a0.f14551a;
        AudioTrack.Builder sessionId = new AudioTrack.Builder().setAudioAttributes(mVar.f6096d ? new AudioAttributes.Builder().setContentType(3).setFlags(16).setUsage(1).build() : (AudioAttributes) cVar.b().f12977a).setAudioFormat(new AudioFormat.Builder().setSampleRate(i11).setChannelMask(i12).setEncoding(i13).build()).setTransferMode(1).setBufferSizeInBytes(mVar.f).setSessionId(i);
        if (i10 >= 29) {
            sessionId.setOffloadedPlayback(mVar.f6097e);
        }
        if (i10 >= 34 && context != null) {
            sessionId.setContext(context);
        }
        return sessionId.build();
    }
}
