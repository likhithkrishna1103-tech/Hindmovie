package o4;

import a2.n1;
import android.content.res.AssetManager;
import android.os.Build;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f9335a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f9336b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f9337c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final File f9338d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f9339e;
    public boolean f = false;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public b[] f9340g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public byte[] f9341h;

    public a(AssetManager assetManager, Executor executor, d dVar, String str, File file) {
        this.f9335a = executor;
        this.f9336b = dVar;
        this.f9339e = str;
        this.f9338d = file;
        int i = Build.VERSION.SDK_INT;
        byte[] bArr = null;
        if (i >= 24) {
            if (i < 31) {
                switch (i) {
                    case 24:
                    case 25:
                        bArr = e.f9356h;
                        break;
                    case 26:
                        bArr = e.f9355g;
                        break;
                    case 27:
                        bArr = e.f;
                        break;
                    case 28:
                    case 29:
                    case 30:
                        bArr = e.f9354e;
                        break;
                }
            } else {
                bArr = e.f9353d;
            }
        }
        this.f9337c = bArr;
    }

    public final FileInputStream a(AssetManager assetManager, String str) {
        try {
            return assetManager.openFd(str).createInputStream();
        } catch (FileNotFoundException e10) {
            String message = e10.getMessage();
            if (message == null || !message.contains("compressed")) {
                return null;
            }
            this.f9336b.l();
            return null;
        }
    }

    public final void b(int i, Serializable serializable) {
        this.f9335a.execute(new n1(this, i, serializable, 4));
    }
}
