package nc;

import a2.g0;
import android.widget.TextView;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.google.android.material.tabs.TabLayout;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class j implements Runnable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f8940u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ m f8941v;

    public /* synthetic */ j(m mVar, int i) {
        this.f8940u = i;
        this.f8941v = mVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        FileReader fileReader;
        BufferedReader bufferedReader;
        switch (this.f8940u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                m mVar = this.f8941v;
                StringBuilder sb2 = new StringBuilder();
                try {
                    fileReader = new FileReader(new File(mVar.f8949y0));
                    try {
                        bufferedReader = new BufferedReader(fileReader);
                    } finally {
                        try {
                            break;
                        } catch (Throwable th) {
                        }
                    }
                } catch (IOException unused) {
                    mVar.G().runOnUiThread(new j(mVar, 1));
                    return;
                }
                while (true) {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        mVar.G().runOnUiThread(new g0(mVar, 28, sb2));
                        fileReader.close();
                        return;
                    } else {
                        sb2.append(line);
                        sb2.append("\n");
                    }
                    mVar.G().runOnUiThread(new j(mVar, 1));
                    return;
                }
            case 1:
                m mVar2 = this.f8941v;
                ((SwipeRefreshLayout) mVar2.f8944t0.f1740e).setRefreshing(false);
                ((RecyclerView) mVar2.f8944t0.f1739d).setVisibility(8);
                ((TextView) mVar2.f8944t0.f1738c).setVisibility(0);
                return;
            default:
                TabLayout tabLayout = (TabLayout) this.f8941v.f8944t0.f;
                tabLayout.j(tabLayout.f(0), true);
                return;
        }
    }
}
