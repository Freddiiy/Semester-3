import { PrismaClient } from '@prisma/client'
const prisma = new PrismaClient()

export async function getText() {
    prisma.$connect();
    try {
        const text = await prisma.text.findMany();

        return text;
    } catch (error) {
        console.error(error);
    }

    prisma.$disconnect();
}

export async function insertText(insert: string) {
    prisma.$connect();
    try {
        await prisma.text.create({
            data: {
                text: insert 
            }
        });
    } catch(error) {
        console.error(error);
    }
    prisma.$disconnect();
}