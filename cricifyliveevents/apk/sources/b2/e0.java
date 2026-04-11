package b2;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class e0 extends c {
    public o A;
    public AssetFileDescriptor B;
    public FileInputStream C;
    public long D;
    public boolean E;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Context f1682z;

    public e0(Context context) {
        super(false);
        this.f1682z = context.getApplicationContext();
    }

    @Deprecated
    public static Uri buildRawResourceUri(int i) {
        return Uri.parse("rawresource:///" + i);
    }

    @Override // b2.h
    public final long B(o oVar) throws d0 {
        Resources resourcesForApplication;
        int identifier;
        int i;
        Resources resources;
        this.A = oVar;
        e();
        Uri uri = oVar.f1714a;
        long j4 = oVar.f1719g;
        long j7 = oVar.f;
        Uri uriNormalizeScheme = uri.normalizeScheme();
        boolean zEquals = TextUtils.equals("rawresource", uriNormalizeScheme.getScheme());
        Context context = this.f1682z;
        if (zEquals) {
            resources = context.getResources();
            List<String> pathSegments = uriNormalizeScheme.getPathSegments();
            if (pathSegments.size() != 1) {
                throw new d0("rawresource:// URI must have exactly one path element, found " + pathSegments.size(), null, 2000);
            }
            try {
                i = Integer.parseInt(pathSegments.get(0));
            } catch (NumberFormatException unused) {
                throw new d0("Resource identifier must be an integer.", null, 1004);
            }
        } else {
            if (!TextUtils.equals("android.resource", uriNormalizeScheme.getScheme())) {
                throw new d0("Unsupported URI scheme (" + uriNormalizeScheme.getScheme() + "). Only android.resource is supported.", null, 1004);
            }
            String path = uriNormalizeScheme.getPath();
            path.getClass();
            if (path.startsWith("/")) {
                path = path.substring(1);
            }
            String packageName = TextUtils.isEmpty(uriNormalizeScheme.getHost()) ? context.getPackageName() : uriNormalizeScheme.getHost();
            if (packageName.equals(context.getPackageName())) {
                resourcesForApplication = context.getResources();
            } else {
                try {
                    resourcesForApplication = context.getPackageManager().getResourcesForApplication(packageName);
                } catch (PackageManager.NameNotFoundException e9) {
                    throw new d0("Package in android.resource:// URI not found. Check http://g.co/dev/packagevisibility.", e9, 2005);
                }
            }
            if (path.matches("\\d+")) {
                try {
                    identifier = Integer.parseInt(path);
                } catch (NumberFormatException unused2) {
                    throw new d0("Resource identifier must be an integer.", null, 1004);
                }
            } else {
                identifier = resourcesForApplication.getIdentifier(packageName + ":" + path, "raw", null);
                if (identifier == 0) {
                    throw new d0("Resource not found.", null, 2005);
                }
            }
            i = identifier;
            resources = resourcesForApplication;
        }
        try {
            AssetFileDescriptor assetFileDescriptorOpenRawResourceFd = resources.openRawResourceFd(i);
            if (assetFileDescriptorOpenRawResourceFd == null) {
                throw new d0("Resource is compressed: " + uriNormalizeScheme, null, 2000);
            }
            this.B = assetFileDescriptorOpenRawResourceFd;
            long length = assetFileDescriptorOpenRawResourceFd.getLength();
            FileInputStream fileInputStream = new FileInputStream(this.B.getFileDescriptor());
            this.C = fileInputStream;
            try {
                if (length != -1 && j7 > length) {
                    throw new d0(null, null, 2008);
                }
                long startOffset = this.B.getStartOffset();
                long jSkip = fileInputStream.skip(startOffset + j7) - startOffset;
                if (jSkip != j7) {
                    throw new d0(null, null, 2008);
                }
                if (length == -1) {
                    FileChannel channel = fileInputStream.getChannel();
                    if (channel.size() == 0) {
                        this.D = -1L;
                    } else {
                        long size = channel.size() - channel.position();
                        this.D = size;
                        if (size < 0) {
                            throw new d0(null, null, 2008);
                        }
                    }
                } else {
                    long j10 = length - jSkip;
                    this.D = j10;
                    if (j10 < 0) {
                        throw new l(2008);
                    }
                }
                if (j4 != -1) {
                    long j11 = this.D;
                    this.D = j11 == -1 ? j4 : Math.min(j11, j4);
                }
                this.E = true;
                f(oVar);
                return j4 != -1 ? j4 : this.D;
            } catch (d0 e10) {
                throw e10;
            } catch (IOException e11) {
                throw new d0(null, e11, 2000);
            }
        } catch (Resources.NotFoundException e12) {
            throw new d0(null, e12, 2005);
        }
    }

    @Override // b2.h
    public final void close() {
        this.A = null;
        try {
            try {
                FileInputStream fileInputStream = this.C;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                this.C = null;
                try {
                    try {
                        AssetFileDescriptor assetFileDescriptor = this.B;
                        if (assetFileDescriptor != null) {
                            assetFileDescriptor.close();
                        }
                    } catch (IOException e9) {
                        throw new d0(null, e9, 2000);
                    }
                } finally {
                    this.B = null;
                    if (this.E) {
                        this.E = false;
                        c();
                    }
                }
            } catch (IOException e10) {
                throw new d0(null, e10, 2000);
            }
        } catch (Throwable th) {
            this.C = null;
            try {
                try {
                    AssetFileDescriptor assetFileDescriptor2 = this.B;
                    if (assetFileDescriptor2 != null) {
                        assetFileDescriptor2.close();
                    }
                    this.B = null;
                    if (this.E) {
                        this.E = false;
                        c();
                    }
                    throw th;
                } catch (IOException e11) {
                    throw new d0(null, e11, 2000);
                }
            } finally {
                this.B = null;
                if (this.E) {
                    this.E = false;
                    c();
                }
            }
        }
    }

    @Override // v1.h
    public final int read(byte[] bArr, int i, int i10) throws d0 {
        if (i10 == 0) {
            return 0;
        }
        long j4 = this.D;
        if (j4 != 0) {
            if (j4 != -1) {
                try {
                    i10 = (int) Math.min(j4, i10);
                } catch (IOException e9) {
                    throw new d0(null, e9, 2000);
                }
            }
            FileInputStream fileInputStream = this.C;
            int i11 = y1.a0.f14551a;
            int i12 = fileInputStream.read(bArr, i, i10);
            if (i12 != -1) {
                long j7 = this.D;
                if (j7 != -1) {
                    this.D = j7 - ((long) i12);
                }
                b(i12);
                return i12;
            }
            if (this.D != -1) {
                throw new d0("End of stream reached having not read sufficient data.", new EOFException(), 2000);
            }
        }
        return -1;
    }

    @Override // b2.h
    public final Uri t() {
        o oVar = this.A;
        if (oVar != null) {
            return oVar.f1714a;
        }
        return null;
    }
}
