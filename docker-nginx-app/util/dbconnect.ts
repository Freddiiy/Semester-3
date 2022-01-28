import { PrismaClient } from '@prisma/client'
const prisma = new PrismaClient()

export async function getText() {
    prisma.$connect();

    const text = await prisma.test.findUnique({
        where: {
            id: 1,
        },
    });

    return text?.test;
}