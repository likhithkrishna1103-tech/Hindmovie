package x5;

import android.widget.TextView;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.google.android.material.tabs.TabLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class f implements Runnable {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f14345v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ i f14346w;

    public /* synthetic */ f(i iVar, int i) {
        this.f14345v = i;
        this.f14346w = iVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        FileReader fileReader;
        BufferedReader bufferedReader;
        switch (this.f14345v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                i iVar = this.f14346w;
                StringBuilder sb = new StringBuilder();
                try {
                    fileReader = new FileReader(new File(iVar.f14353z0));
                    try {
                        bufferedReader = new BufferedReader(fileReader);
                    } finally {
                        try {
                            break;
                        } catch (Throwable th) {
                        }
                    }
                } catch (IOException unused) {
                    iVar.J().runOnUiThread(new f(iVar, 1));
                    return;
                }
                while (true) {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        iVar.J().runOnUiThread(new nc.i(12, iVar, sb));
                        fileReader.close();
                        return;
                    } else {
                        sb.append(line);
                        sb.append("\n");
                    }
                    iVar.J().runOnUiThread(new f(iVar, 1));
                    return;
                }
            case 1:
                i iVar2 = this.f14346w;
                ((SwipeRefreshLayout) iVar2.f14348u0.f2038e).setRefreshing(false);
                ((RecyclerView) iVar2.f14348u0.f2037d).setVisibility(8);
                ((TextView) iVar2.f14348u0.f2036c).setVisibility(0);
                return;
            default:
                TabLayout tabLayout = (TabLayout) this.f14346w.f14348u0.f;
                tabLayout.j(tabLayout.f(0), true);
                return;
        }
    }
}
