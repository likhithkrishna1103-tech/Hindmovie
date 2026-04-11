package d8;

import androidx.media3.decoder.DecoderInputBuffer;
import com.google.android.datatransport.runtime.scheduling.jobscheduling.AlarmManagerSchedulerBroadcastReceiver;
import v1.b0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a implements Runnable {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f3522v = 0;

    public /* synthetic */ a() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3522v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                int i = AlarmManagerSchedulerBroadcastReceiver.f2300a;
                break;
        }
    }

    public /* synthetic */ a(b0 b0Var) {
    }

    public /* synthetic */ a(b0 b0Var, cd.b bVar) {
    }

    private final void a() {
    }

    private final void b() {
    }
}
