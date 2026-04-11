package dd;

import androidx.media3.decoder.DecoderInputBuffer;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.AlarmManagerSchedulerBroadcastReceiver;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class c implements Runnable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f4138u = 2;

    public /* synthetic */ c() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f4138u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
            case 1:
                break;
            default:
                int i = AlarmManagerSchedulerBroadcastReceiver.f2865a;
                break;
        }
    }

    public /* synthetic */ c(ia.b bVar) {
    }

    public /* synthetic */ c(ia.b bVar, yc.b bVar2) {
    }

    private final void a() {
    }

    private final void b() {
    }
}
