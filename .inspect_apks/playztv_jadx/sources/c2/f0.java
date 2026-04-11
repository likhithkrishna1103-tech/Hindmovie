package c2;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioTrack;
import android.os.Build;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f0 f2307a = new f0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final f0 f2308b = new f0();

    public AudioTrack a(k kVar, p1.d dVar, int i, Context context) {
        int i10 = Build.VERSION.SDK_INT;
        int i11 = kVar.f2352b;
        int i12 = kVar.f2353c;
        int i13 = kVar.f2351a;
        int i14 = s1.b0.f11647a;
        AudioTrack.Builder sessionId = new AudioTrack.Builder().setAudioAttributes(kVar.f2354d ? new AudioAttributes.Builder().setContentType(3).setFlags(16).setUsage(1).build() : (AudioAttributes) dVar.b().f10045a).setAudioFormat(new AudioFormat.Builder().setSampleRate(i11).setChannelMask(i12).setEncoding(i13).build()).setTransferMode(1).setBufferSizeInBytes(kVar.f).setSessionId(i);
        if (i10 >= 29) {
            sessionId.setOffloadedPlayback(kVar.f2355e);
        }
        if (i10 >= 34 && context != null) {
            sessionId.setContext(context);
        }
        return sessionId.build();
    }
}
